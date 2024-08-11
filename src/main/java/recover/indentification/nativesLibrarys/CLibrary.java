package recover.indentification.nativesLibrarys;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.ptr.LongByReference;

public interface CLibrary extends Library {

    CLibrary INSTANCE = Native.load(Platform.isWindows() ? "msvcrt" : "c", CLibrary.class);

    int stat(String path, Stat statfs);
    int ioctl(int fd, long request, LongByReference size);
    int open(String path, int flags);
    int close(int fd);
}
