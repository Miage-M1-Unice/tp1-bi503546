package fr.miage.master1.tp1.exo1.point3;
import java.io.File;
import java.io.FileFilter;

class Filter2 implements FileFilter {

    private String extension;

    public Filter2 (String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept (File file) {
        return file.isFile() && file.getName().contains(extension) || file.isDirectory();
    }
}

