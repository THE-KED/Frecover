package recover.indentification.nativesLibrarys;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

@Structure.FieldOrder({"f_type", "f_bsize", "f_blocks", "f_bfree", "f_bavail", "f_files", "f_ffree", "f_fsid", "f_namelen", "f_frsize", "f_flags", "f_spare"})
public class Stat extends Structure {
    public long f_type;
    public long f_bsize;
    public long f_blocks;
    public long f_bfree;
    public long f_bavail;
    public long f_files;
    public long f_ffree;
    public long[] f_fsid = new long[2];
    public long f_namelen;
    public long f_frsize;
    public long f_flags;
    public long[] f_spare = new long[4];

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("f_type", "f_bsize", "f_blocks", "f_bfree", "f_bavail", "f_files", "f_ffree", "f_fsid", "f_namelen", "f_frsize", "f_flags", "f_spare");
    }

    @Override
    public String toString() {
        return "Stat{" +
                "f_type=" + f_type +
                ", f_bsize=" + f_bsize +
                ", f_blocks=" + f_blocks +
                ", f_bfree=" + f_bfree +
                ", f_bavail=" + f_bavail +
                ", f_files=" + f_files +
                ", f_ffree=" + f_ffree +
                ", f_fsid=" + Arrays.toString(f_fsid) +
                ", f_namelen=" + f_namelen +
                ", f_frsize=" + f_frsize +
                ", f_flags=" + f_flags +
                ", f_spare=" + Arrays.toString(f_spare) +
                '}';
    }
}
