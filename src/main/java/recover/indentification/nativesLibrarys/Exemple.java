package recover.indentification.nativesLibrarys;

import com.sun.jna.Native;
import com.sun.jna.ptr.LongByReference;

public class Exemple {

    public static int major(long dev) {
        return (int) ((dev >> 8) & 0xfff);
    }

    public static int minor(long dev) {
        return (int) (dev & 0xff);
    }

    public static void main(String[] args) {
        String device = "/dev/sdb1";
        String mountPoint = "/mnt"; // Change this to the actual mount point of the device

        // Get filesystem type
        Stat statfs = new Stat();
        if (CLibrary.INSTANCE.stat(mountPoint, statfs) != 0) {
            System.err.println("statfs failed: " + Native.getLastError());
            return;
        }
        System.out.printf("Filesystem type: 0x%x\n", statfs.f_type); // You may need to map this to a human-readable filesystem name

        // Get partition size
        int fd = CLibrary.INSTANCE.open(device, 0);
        if (fd < 0) {
            System.err.println("open failed: " + Native.getLastError());
            return;
        }

        LongByReference size = new LongByReference();
        if (CLibrary.INSTANCE.ioctl(fd, 0x80081272L, size) != 0) { // BLKGETSIZE64
            System.err.println("ioctl failed: " + Native.getLastError());
            CLibrary.INSTANCE.close(fd);
            return;
        }
        CLibrary.INSTANCE.close(fd);

        System.out.println("Partition size: " + size.getValue() + " bytes");
        System.out.println("stat:"+statfs.toString());
    }
}
