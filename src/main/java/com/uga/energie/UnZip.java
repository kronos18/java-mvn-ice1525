package com.uga.energie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {

    List<String> fileList;


    public static void main(String[] args) {
        UnZip unZip = new UnZip();

        /*
        System.out.println("Nombre d'argument : " + args.length);
        System.out.println("les arguments : ");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        */

        if (args.length == 2) {
            unZip.unZipAllFiles(args[0], args[1]);
        } else {
            String INPUT_ZIP_FILE = "C:\\Users\\Artybloc\\Dropbox\\Master\\M2S2\\LinlyBDD\\data.zip";
            String OUTPUT_FOLDER = "D:\\Temp";
            unZip.unZipAllFiles(INPUT_ZIP_FILE, OUTPUT_FOLDER);
        }
    }

    public void unZipIt(String zipFile, String outputFolder) {

        byte[] buffer = new byte[1024];

        try {

            //create output directory is not exists
            File folder = new File(outputFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }

            //get the zip file content
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {

                String fileName = ze.getName();
                File newFile = new File(outputFolder + File.separator + fileName);

                System.out.println("file unzip : " + newFile.getAbsoluteFile());

                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }

                fos.close();
                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void UnZipLevelOne(String INPUT_ZIP_FILE, String OUTPUT_FOLDER){
        unZipIt(INPUT_ZIP_FILE, OUTPUT_FOLDER);
    }

    public void UnZipLevelTwo(String OUTPUT_FOLDER){
        File folder = new File(OUTPUT_FOLDER + "\\data");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
                unZipIt(file.getAbsolutePath(), OUTPUT_FOLDER);
            }
        }
    }

    public void deleteOldZip(String OUTPUT_FOLDER){
        File directory = new File(OUTPUT_FOLDER + "\\data");

        //make sure directory exists
        if(!directory.exists()){

            System.out.println("Directory does not exist.");
            System.exit(0);

        }else{

            try{

                delete(directory);

            }catch(IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }

    }

    public void unZipAllFiles(String INPUT_ZIP_FILE, String OUTPUT_FOLDER){
        System.out.println("-------------------------------- NIVEAU 1 ------------------------------------");
        UnZipLevelOne(INPUT_ZIP_FILE, OUTPUT_FOLDER);
        System.out.println("-------------------------------- NIVEAU 2 ------------------------------------");
        UnZipLevelTwo(OUTPUT_FOLDER);
        System.out.println("---------------------------- DELETE OLD FILES --------------------------------");
        deleteOldZip(OUTPUT_FOLDER);
    }

    public static void delete(File file)
            throws IOException{

        if(file.isDirectory()){

            //directory is empty, then delete it
            if(file.list().length==0){

                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());

            }else{

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    delete(fileDelete);
                }

                //check the directory again, if empty then delete it
                if(file.list().length==0){
                    file.delete();
                    System.out.println("Directory is deleted : "
                            + file.getAbsolutePath());
                }
            }

        }else{
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }
}

