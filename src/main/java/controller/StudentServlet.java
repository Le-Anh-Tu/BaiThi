package controller;



import model.Classroom;
import model.Student;
import service.classroom.ClassroomService;
import service.classroom.IClassroomService;
import service.student.IStudentService;

import service.student.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    IStudentService studentService = new StudentService();
    IClassroomService classroomService = new ClassroomService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showCreateForm(request, response);
                break;
            }
            case "update": {
                showUpdateForm(request, response);
                break;
            }
            case "delete": {
                deleteStudent(request, response);
                break;
            }
            default: {
                showStudent(request, response);
            }
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        if (student == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            studentService.delete(id);
            try {
                response.sendRedirect("/student");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);
        List<Classroom> classrooms = classroomService.show();
        request.setAttribute("classrooms", classrooms);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            List<Classroom> classrooms = classroomService.show();
            request.setAttribute("classrooms", classrooms);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showStudent(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
        List<Student> students = studentService.show();

//        if (name == null || name.equals("")) {
//            students = studentService.show();
//        } else {
//            students = studentService.searchProductByName(name);
//        }
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/show.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                createNewStudent(request, response);
                break;
            }
            case "update": {
                updateStudentInfo(request, response);
                break;
            }
        }
    }

    private void updateStudentInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int classroomId = Integer.parseInt(request.getParameter("classroomId"));
        studentService.update(id, new Student(name, address, phoneNumber, email, classroomId));
        List<Classroom> classrooms = classroomService.show();
        request.setAttribute("classrooms", classrooms);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int classroomId = Integer.parseInt(request.getParameter("classroomId"));
        studentService.create(new Student(name, address, phoneNumber, email, classroomId));
        List<Classroom> classrooms = classroomService.show();
        request.setAttribute("classrooms", classrooms);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
