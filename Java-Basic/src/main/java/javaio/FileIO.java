package javaio;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

/**
 * Created by Mark on 2016/3/15.
 */
public class FileIO {
    public static void main(String[] args) {
        // Get a file object to represent the user's home directory
        File homedir = new File(System.getProperty("user.home"));
        // Create an object to represent a config file (should
        // already be present in the home directory)
        File f = new File(homedir, "app.conf");
        // Check the file exists, really is a file & is readable
        if (f.exists() && f.isFile() && f.canRead()) {
            // Create a file object for a new configuration directory
            File configdir = new File(f, ".configdir");
            // And create it
            configdir.mkdir();
            // Finally, move the config file to its new home
            f.renameTo(new File(configdir, ".config"));
        }
    }

    public void fileOperations() throws IOException {
        File f = new File(System.getProperty("user.home"));
        // Permissions management
        boolean canX = f.canExecute();
        boolean canR = f.canRead();
        boolean canW = f.canWrite();
        boolean ok;
        ok = f.setReadOnly();
        ok = f.setExecutable(true);
        ok = f.setReadable(true);
        ok = f.setWritable(false);
        // Different views of the file's name
        File absF = f.getAbsoluteFile();
        File canF = f.getCanonicalFile();
        String absName = f.getAbsolutePath();
        String canName = f.getCanonicalPath();
        String name = f.getName();
        String pName = f.getParent();
        URI fileURI = f.toURI(); // Create URI for File path
        // File metadata
        boolean exists = f.exists();
        boolean isAbs = f.isAbsolute();
        boolean isDir = f.isDirectory();
        boolean isFile = f.isFile();
        boolean isHidden = f.isHidden();
        long modTime = f.lastModified(); // milliseconds since epoch
        boolean updateOK = f.setLastModified(new Date().getTime()); // milliseconds
        long fileLen = f.length();
        // File management operations
        boolean renamed = f.renameTo(new File(""));
        boolean deleted = f.delete();
        // Create won't overwrite existing file
        boolean createdOK = f.createNewFile();
        // Temporary file handling
        File tmp = File.createTempFile("my-tmp", ".tmp");
        tmp.deleteOnExit();
        File dir = new File("");
        // Directory handling
        boolean createdDir = dir.mkdir();
        String[] fileNames = dir.list();
        File[] files = dir.listFiles();


        long free, total, usable;
        free = f.getFreeSpace();
        total = f.getTotalSpace();
        usable = f.getUsableSpace();
        File[] roots = File.listRoots(); // all available Filesystem roots


    }
}

