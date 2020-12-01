import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ClientSoket implements Runnable {
    private Socket soc;
    private Group group;
    private String ansv;
    private Thread t;

    public ClientSoket(Socket soc, Group group) {
        super();
        this.soc = soc;
        this.ansv = null;
        this.group = group;
        t = new Thread(this);
        t.start();
    }

    public ClientSoket() {
    }

    public void run() {
        try (InputStream is = soc.getInputStream();
             OutputStream os = soc.getOutputStream();
             PrintWriter pw = new PrintWriter(os)) {
            BufferedReader isis = new BufferedReader(new InputStreamReader(is));
            String question = "";
            String currentString = "";
            byte[] rec1 = new byte[is.available()];
            is.read(rec1);
            String bString = new String(rec1, StandardCharsets.UTF_8);
            System.out.println(bString);
            String ansver = "";
            if (!bString.contains("ByScholarship") && !bString.contains("ByAcademicPerformance") && !bString.contains("ByAge")) {
                ansver = "";
                ansver += "<html><head><title>Student</title> <meta charset='utf-8'></head><body><p>Список студентов группы: " + "</p><br>";
                ansver += "<table border='2' cellpadding='5' ><tr><th>Фамилия</th><th>Имя</th><th>Стипендия</th><th>Успеваемость</th><th>Возраст</th></tr>";
                List<Student> starr = group.getGroup();
                for (int i = 0; i < starr.size(); i++) {
                    ansver += "<tr>";
                    ansver += "<td>" + starr.get(i).getName() + "</td>";
                    ansver += "<td>" + starr.get(i).getSurname() + "</td>";
                    ansver += "<td>" + starr.get(i).getScholarship() + "</td>";
                    ansver += "<td>" + starr.get(i).getAcademicPerformance() + "</td>";
                    ansver += "<td>" + starr.get(i).getAge() + "</td>";
                    ansver += "</tr>";
                }
                ansver += "</table></body></html>";
                ansver += "<button onclick=\"window.location.href='/ByAcademicPerformance'\">By AcademicPerformance</button>";
                ansver += "<button onclick=\"window.location.href='/ByScholarship'\">By Scholarship</button>";
                ansver += "<button onclick=\"window.location.href='/ByAge'\">By Age</button>";
                ansver += "<button onclick=\"window.location.href='/ByName'\">By Name</button>";
            }
            if (bString.contains("ByScholarship")) {
                ansver = "";
                ClientSoket cli = new ClientSoket(this.soc, group);
                ansver += "<html><head><title>Student</title> <meta charset='utf-8'></head><body><p>Список студентов группы: " + "</p><br>";
                ansver += "<table border='2' cellpadding='5' ><tr><th>Фамилия</th><th>Имя</th><th>Стипендия</th><th>Успеваемость</th><th>Возраст</th></tr>";
                group = SortingGroup.sortScholarship(group);
                List<Student> starr = group.getGroup();
                for (int i = 0; i < starr.size(); i++) {
                    ansver += "<tr>";
                    ansver += "<td>" + starr.get(i).getName() + "</td>";
                    ansver += "<td>" + starr.get(i).getSurname() + "</td>";
                    ansver += "<td>" + starr.get(i).getScholarship() + "</td>";
                    ansver += "<td>" + starr.get(i).getAcademicPerformance() + "</td>";
                    ansver += "<td>" + starr.get(i).getAge() + "</td>";
                    ansver += "</tr>";
                }
                ansver += "</table></body></html>";
                ansver += "<button onclick=\"window.location.href='/ByAcademicPerformance'\">By AcademicPerformance</button>";
                ansver += "<button onclick=\"window.location.href='/ByScholarship'\">By Scholarship</button>";
                ansver += "<button onclick=\"window.location.href='/ByAge'\">By Age</button>";
                ansver += "<button onclick=\"window.location.href='/ByName'\">By Name</button>";
            }

            if (bString.contains("ByAcademicPerformance")) {
                ansver = "";
                ClientSoket cli = new ClientSoket(this.soc, group);
                ansver += "<html><head><title>Student</title> <meta charset='utf-8'></head><body><p>Список студентов группы: " + "</p><br>";
                ansver += "<table border='2' cellpadding='5' ><tr><th>Фамилия</th><th>Имя</th><th>Стипендия</th><th>Успеваемость</th><th>Возраст</th></tr>";
                group = SortingGroup.sortAcademicPerformance(group);
                List<Student> starr = group.getGroup();
                for (int i = 0; i < starr.size(); i++) {
                    ansver += "<tr>";
                    ansver += "<td>" + starr.get(i).getName() + "</td>";
                    ansver += "<td>" + starr.get(i).getSurname() + "</td>";
                    ansver += "<td>" + starr.get(i).getScholarship() + "</td>";
                    ansver += "<td>" + starr.get(i).getAcademicPerformance() + "</td>";
                    ansver += "<td>" + starr.get(i).getAge() + "</td>";
                    ansver += "</tr>";
                }
                ansver += "</table></body></html>";
                ansver += "<button onclick=\"window.location.href='/ByAcademicPerformance'\">By AcademicPerformance</button>";
                ansver += "<button onclick=\"window.location.href='/ByScholarship'\">By Scholarship</button>";
                ansver += "<button onclick=\"window.location.href='/ByAge'\">By Age</button>";
                ansver += "<button onclick=\"window.location.href='/ByName'\">By Name</button>";
            }

            if (bString.contains("ByAge")) {
                ansver = "";
                ClientSoket cli = new ClientSoket(this.soc, group);
                ansver += "<html><head><title>Student</title> <meta charset='utf-8'></head><body><p>Список студентов группы: " + "</p><br>";
                ansver += "<table border='2' cellpadding='5' ><tr><th>Фамилия</th><th>Имя</th><th>Стипендия</th><th>Успеваемость</th><th>Возраст</th></tr>";
                group = SortingGroup.sortAge(group);
                List<Student> starr = group.getGroup();
                for (int i = 0; i < starr.size(); i++) {
                    ansver += "<tr>";
                    ansver += "<td>" + starr.get(i).getName() + "</td>";
                    ansver += "<td>" + starr.get(i).getSurname() + "</td>";
                    ansver += "<td>" + starr.get(i).getScholarship() + "</td>";
                    ansver += "<td>" + starr.get(i).getAcademicPerformance() + "</td>";
                    ansver += "<td>" + starr.get(i).getAge() + "</td>";
                    ansver += "</tr>";
                }
                ansver += "</table></body></html>";
                ansver += "<button onclick=\"window.location.href='/ByAcademicPerformance'\">By AcademicPerformance</button>";
                ansver += "<button onclick=\"window.location.href='/ByScholarship'\">By Scholarship</button>";
                ansver += "<button onclick=\"window.location.href='/ByAge'\">By Age</button>";
                ansver += "<button onclick=\"window.location.href='/ByName'\">By Name</button>";
            }
            if (bString.contains("ByName")) {
                ansver = "";
                ClientSoket cli = new ClientSoket(this.soc, group);
                ansver += "<html><head><title>Student</title> <meta charset='utf-8'></head><body><p>Список студентов группы: " + "</p><br>";
                ansver += "<table border='2' cellpadding='5' ><tr><th>Фамилия</th><th>Имя</th><th>Стипендия</th><th>Успеваемость</th><th>Возраст</th></tr>";
                group = SortingGroup.sortName(group);
                List<Student> starr = group.getGroup();
                for (int i = 0; i < starr.size(); i++) {
                    ansver += "<tr>";
                    ansver += "<td>" + starr.get(i).getName() + "</td>";
                    ansver += "<td>" + starr.get(i).getSurname() + "</td>";
                    ansver += "<td>" + starr.get(i).getScholarship() + "</td>";
                    ansver += "<td>" + starr.get(i).getAcademicPerformance() + "</td>";
                    ansver += "<td>" + starr.get(i).getAge() + "</td>";
                    ansver += "</tr>";
                }
                ansver += "</table></body></html>";
                ansver += "<button onclick=\"window.location.href='/ByAcademicPerformance'\">By AcademicPerformance</button>";
                ansver += "<button onclick=\"window.location.href='/ByScholarship'\">By Scholarship</button>";
                ansver += "<button onclick=\"window.location.href='/ByAge'\">By Age</button>";
                ansver += "<button onclick=\"window.location.href='/ByName'\">By Name</button>";
            }
            String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type:text/html \r\n" +
                    "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
            pw.print(response + ansver);
            pw.flush();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

