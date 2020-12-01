import java.io.*;

public class WorkWithDatabase {
    public static Group databaseConnection() {
        Group group = new Group();
        String dataFtomFile = "";
        try (BufferedReader fileRead = new BufferedReader(new FileReader("DataStudent.txt"))) {
            while (fileRead.read() != -1) {
                dataFtomFile = dataFtomFile + fileRead.readLine() + ",";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arryDataStudent = dataFtomFile.split(",");
        for (String stringDataStudent : arryDataStudent) {
            String[] arryDataForEachStudent = stringDataStudent.split(" ");
            Student student = new Student();
            student.setAge(Integer.parseInt(arryDataForEachStudent[0]));
            student.setName(arryDataForEachStudent[1]);
            student.setSurname(arryDataForEachStudent[2]);
            student.setGender(arryDataForEachStudent[3]);
            student.setAcademicPerformance(Integer.valueOf(arryDataForEachStudent[4]));
            student.setScholarship(Integer.valueOf(arryDataForEachStudent[5]));
            try {
                group.addStudent(student);
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        return group;
    }

    public static void studentRegistration(Student student) throws MyException {
        String dataSudentForWreaterInFile = " " + student.getAge() + " " + student.getName() + " "
                + student.getSurname() + " " + student.getGender() + " " + student.getAcademicPerformance() + " "
                + student.getScholarship();
        int quantityStudensInDatabase = 0;
        try (FileWriter fileWriter = new FileWriter("DataStudent.txt", true);
             BufferedReader fileRead = new BufferedReader(new FileReader("DataStudent.txt"))) {
            while (fileRead.read() != -1) {
                fileRead.readLine();
                quantityStudensInDatabase++;
            }
            if (quantityStudensInDatabase == 10) {
                throw new MyException();
            }
            fileWriter.write(dataSudentForWreaterInFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
