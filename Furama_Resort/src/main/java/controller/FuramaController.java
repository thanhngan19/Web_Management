package controller;

import model.*;
import service.CategoryService;
import service.*;
import validate.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "furama", value = "/furama")
public class FuramaController extends HttpServlet {
    IEmployeeService serviceEm= new EmployeeService();
    private ICustomerService serviceCus= new CustomerService();
    private IServiceFurama serviceFu= new ServiceFurama();
    private IContractService serviceContract= new ContractService();
    private IContractDetailService serviceDetail = new ContractDetailService();
    private IUserService user = new UserService();
    private ICategoryService cate= new CategoryService();
    private IBookingRoomService booking= new BookingRoomService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showFormEmployee":
                findAllEmployee(req,resp);
                break;
            case"showFormCreate":
                showFormCreate(req,resp);
                break;
            case"showFormEdit":
                showFormEdit(req,resp);
                break;
            case"showFormDelete":
                formDelete(req,resp);
                break;
            case"showFormEdited":
                formEdit(req,resp);
                break;
            case "showFormSearch":
                showFormSearch(req,resp);
                break;
            case"show":
                finaAllCustomer(req,resp);
                break;
            case "showEdit":
                showEdit(req,resp);
                break;
            case"showCreate":
                showCreate(req,resp);
                break;
            case"showService":
                findAllService(req,resp);
                break;
            case"createService":
                showCreateService(req,resp);
                break;
            case"showFormContract":
                showFormContract(req,resp);
                break;
            case"createContract":
                showFormCreateContract(req,resp);
                break;
            case"showFormCreateContractDetail":
                showFormCreateContractDetail(req,resp);
                break;
            case"showFormContractDetail":
                showFormContractDetail(req,resp);
                break;
            case"login":
                showFormLogin(req,resp);
                break;
            case"showFormAdmin":
                showFormAdmin(req,resp);
                break;
            case"showFormBooking":
                showFormBooking(req,resp);
                break;

            default:
                findAll(req,resp);
                break;
        }
    }
    private void showFormBooking(HttpServletRequest req, HttpServletResponse resp){

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case"createEmployee":
                insertEmployee(req,resp);
                break;
            case"deleteEmployee":
                deleteEmployee(req,resp);
                break;
            case"update":
                updateEmployee(req,resp);
                break;
            case"search":
                searchByName(req,resp);
                break;
            case"updateCustomer":
                update(req,resp);
                break;
            case"createCustomer":
                create(req,resp);
                break;
            case"delete":
                delete(req,resp);
                break;
            case"searchCustomer":
                search(req,resp);
                break;
            case"createService":
                createService(req,resp);
                break;
            case "createContract":
                createContract(req,resp);
                break;
            case"detail":
                showFormContractDetail(req,resp);
                break;
            case"createContractDetail":
                createContractDetail(req,resp);
                break;
            case"checkLogin":
                checkLogin(req,resp);
                break;
            case"showFromSignIn":
                showFormSignUp(req,resp);
                break;
            default:
                findAll(req, resp);
                break;

        }
    }
    private void showFormSignUp(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String startDateString = req.getParameter("startdate");
        String endDateString = req.getParameter("enddate");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        LocalDateTime parsedDateTime = LocalDateTime.parse(startDateString, formatter);
        LocalDateTime parsedDateTime2 = LocalDateTime.parse(endDateString, formatter);

        String mess = req.getParameter("message");
        int idLdv = Integer.parseInt(req.getParameter("idCate"));
        cate.selectById(idLdv);

        booking.addNew(new BookingRoom(name, quantity, parsedDateTime, parsedDateTime2, mess, idLdv));

        req.setAttribute("category", cate.selectById(idLdv));
        req.setAttribute("startdate", parsedDateTime);

        try {
            req.getRequestDispatcher("/signup.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }



    }
    private void checkLogin(HttpServletRequest req, HttpServletResponse resp){
        String userName = req.getParameter("username");
        String passWord= req.getParameter("password");
        User userCheck = new User(userName,passWord);
        if(user.checkPass(userCheck)){
            HttpSession session = req.getSession(true);
            session.setAttribute("username", userName);
            try {
         req.setAttribute("username",userName);
         req.getRequestDispatcher("/admin.jsp").forward(req,resp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                resp.sendRedirect("/furama?action=login&number=1");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void showFormAdmin(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.getRequestDispatcher("/admin.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void showFormLogin(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormCreateContractDetail(HttpServletRequest req, HttpServletResponse resp){
        List<Integer> hd= serviceDetail.seContract();
        List<String> service= serviceDetail.seService();
        req.setAttribute("dvdk",service);
        req.setAttribute("mhd",hd);
        try {
            req.getRequestDispatcher("/contract_detail_add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void createContractDetail(HttpServletRequest req, HttpServletResponse resp){
        int sl = Integer.parseInt(req.getParameter("sl"));
        int mhd= Integer.parseInt(req.getParameter("mhd"));
        String dvdk= req.getParameter("dvdk");
        Contract_Detail detail = new Contract_Detail(sl,mhd,dvdk);
        if (!Validator.test(mhd)) {
            serviceDetail.addNew(detail);
            try {
                resp.sendRedirect("/furama?action=showFormContractDetail");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else{
            String message="Hợp đồng được tạo rồi!!";
            req.setAttribute("message",message);
            req.setAttribute("sl",sl);
            try {
                req.getRequestDispatcher("contract_detail_add.jsp?action").forward(req,resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
    public void createContract(HttpServletRequest req, HttpServletResponse resp){
      String startdate = req.getParameter("startdate");
      String enddate = req.getParameter("enddate");
      Double tdc= Double.valueOf(req.getParameter("tdc"));
      String nv = req.getParameter("nv");
      String kh= req.getParameter("kh");
      String dv= req.getParameter("dv");
      Contracts contract = new Contracts(startdate,enddate,tdc,nv,kh,dv);
        serviceContract.addAll(contract);
        try {
            resp.sendRedirect("/furama?action=showFormContract");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormContract(HttpServletRequest req, HttpServletResponse resp){
        List<Contracts> contractList = serviceContract.findAll();
        req.setAttribute("contract", contractList);
        try {
            req.getRequestDispatcher("/contract_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void showFormContractDetail(HttpServletRequest req, HttpServletResponse resp){
        List<Contract_Detail> contractList = serviceDetail.findAll();
        req.setAttribute("detail", contractList);
        try {
            req.getRequestDispatcher("/contract_detail_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void showFormCreateContract(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<String> nhanVien = serviceContract.nhanVien();
            List<String> khachHang = serviceContract.khachHang();
            List<String> dichVu = serviceContract.dichVu();
            req.setAttribute("nv",nhanVien);
            req.setAttribute("kh",khachHang);
            req.setAttribute("dv",dichVu);
            req.getRequestDispatcher("/contract_add.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createService (HttpServletRequest req, HttpServletResponse resp){
        String tdv= req.getParameter("tdv");
        String dt= req.getParameter("dt");
        Double cpt= Double.valueOf(req.getParameter("cpt"));
        int sngtd= req.getIntHeader("sngtd");
        String tkt = req.getParameter("tkt");
        String ldv = req.getParameter("ldv");
        String tcp = req.getParameter("tcp");
        String mttnk= req.getParameter("mttnk");
        String dthb= req.getParameter("dthb");
        int st = Integer.parseInt(req.getParameter("st"));
        Service service = new Service(tdv,dt,cpt,sngtd,tkt,ldv,tcp,mttnk,dthb,st);
        serviceFu.addNew(service);
        try {
            resp.sendRedirect("/furama?action=showService&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void findAllService(HttpServletRequest req, HttpServletResponse resp){
        List<Service> services = serviceFu.findAll();
        req.setAttribute("service",services);
        try {
            req.getRequestDispatcher("/service_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showCreateService(HttpServletRequest req, HttpServletResponse resp){
        List<String> ldv= serviceFu.ldv();
        List<String> tkt= serviceFu.tkt();
        req.setAttribute("ldv", ldv);
        req.setAttribute("tkt", tkt);
        try {
            req.getRequestDispatcher("/service_add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void finaAllCustomer(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<Customer> customer= serviceCus.findAll();
        req.setAttribute("customer", customer);
        try {
            req.getRequestDispatcher("/customer_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showEdit(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer=serviceCus.findById(id);
        ArrayList<String> tenLkh= serviceCus.seTenLoaiKhach();
        req.setAttribute("tenLkh",tenLkh);
        req.setAttribute("customer",customer);
        try {
            req.getRequestDispatcher("/customer_edit.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void update(HttpServletRequest req, HttpServletResponse resp){
        int maKh= Integer.parseInt(req.getParameter("maKh"));
        String loaiKh= req.getParameter("tenLkh");
        String date = req.getParameter("date");
        String name= req.getParameter("name");
        int gender= Integer.parseInt(req.getParameter("gender"));
        String cmnd = req.getParameter("cmnd");
        String sdt = req.getParameter("sdt");
        String address= req.getParameter("address");
        String email= req.getParameter("email");
        Customer customer= new Customer(maKh,loaiKh,name,date,gender,cmnd,sdt,address,email);
        serviceCus.edit(customer);
        try {
            resp.sendRedirect("/furama?action=show&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showCreate(HttpServletRequest req, HttpServletResponse resp){
        try {
            ArrayList<String> list = serviceCus.seTenLoaiKhach();
            req.setAttribute("tenLkh",list);
            req.getRequestDispatcher("/customer_add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void create(HttpServletRequest req, HttpServletResponse resp){
        int maKh= Integer.parseInt(req.getParameter("maKh"));
        String loaiKh= req.getParameter("tenLkh");
        String date = req.getParameter("date");
        String name= req.getParameter("name");
        int gender= Integer.parseInt(req.getParameter("gender"));
        String cmnd = req.getParameter("cmnd");
        String sdt = req.getParameter("sdt");
        String address= req.getParameter("address");
        String email= req.getParameter("email");
        Customer customer= new Customer(maKh,loaiKh,date,name,gender,cmnd,sdt,address,email);
        serviceCus.addCustomer(customer);
        try {
            resp.sendRedirect("/furama?action=show&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        serviceCus.deleteCustomer(id);
        try {
            resp.sendRedirect("/furama?action=show&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void search(HttpServletRequest req, HttpServletResponse resp){
        String search= req.getParameter("searchByName");
        ArrayList<Customer> customer= serviceCus.searchByName(search);
        req.setAttribute("customer",customer);
        try {
            req.getRequestDispatcher("/customer_search.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void findAll(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.setAttribute("list",cate.findAll());
            req.getRequestDispatcher("/index1.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void findAllEmployee(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<Employee> em=serviceEm.findAll();
        req.setAttribute("employees",em);
        try {
            req.getRequestDispatcher("/employee_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertEmployee(HttpServletRequest req, HttpServletResponse resp){
       String name = req.getParameter("nameEmployee");
       String date = req.getParameter("date");
       String cmnd= req.getParameter("CMND");
       double slary = Double.parseDouble(req.getParameter("salary"));
       String sdt = req.getParameter("SDT");
       String email = req.getParameter("email");
       String address= req.getParameter("address");
       String vi_tri = req.getParameter("vi_tri");
       String trinh_do= req.getParameter("trinh_do");
       String bo_phan = req.getParameter("bo_phan");
        Employee employee = new Employee(name,date,cmnd,sdt,email,address,slary,vi_tri,trinh_do,bo_phan);
        serviceEm.addNewEmployee(employee);
        try {
            resp.sendRedirect("/furama?action=showFormEmployee&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void showFormCreate(HttpServletRequest req, HttpServletResponse resp){
        try {
            ArrayList<String> trinhDo= serviceEm.setrinhDo();
            ArrayList<String> viTri =serviceEm.seViTri();
            ArrayList<String> boPhan= serviceEm.seBoPhan();
            req.setAttribute("viTri",viTri);
            req.setAttribute("boPhan",boPhan);
            req.setAttribute("trinhDo",trinhDo);
            req.getRequestDispatcher("/emloyee_add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormEdit(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<String> trinhDo= serviceEm.setrinhDo();
        ArrayList<String> viTri =serviceEm.seViTri();
        ArrayList<String> boPhan= serviceEm.seBoPhan();
        req.setAttribute("viTri",viTri);
        req.setAttribute("boPhan",boPhan);
        req.setAttribute("trinhDo",trinhDo);
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = serviceEm.findById(id);
        req.setAttribute("employee",employee);
        try {
            req.getRequestDispatcher("/employee_edit.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("nameEmployee");
        String date = req.getParameter("date");
        String cmnd= req.getParameter("CMND");
        double slary = Double.parseDouble(req.getParameter("salary"));
        String sdt = req.getParameter("SDT");
        String email = req.getParameter("email");
        String address= req.getParameter("address");
        String vi_tri = req.getParameter("vi_tri");
        String trinh_do= req.getParameter("trinh_do");
        String bo_phan = req.getParameter("bo_phan");
        int ma_nhan_vien= Integer.parseInt(req.getParameter("maNhanVien"));
        Employee employee = new Employee(ma_nhan_vien,name,date,cmnd,sdt,email,address,slary,vi_tri,trinh_do,bo_phan);
        serviceEm.edit(employee);
        try {
            resp.sendRedirect("/furama?action=showFormEmployee&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void edit(HttpServletRequest req, HttpServletResponse resp){

    }
    public void formDelete(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<Employee> em=serviceEm.findAll();
        req.setAttribute("employees",em);
        try {
            req.getRequestDispatcher("/employee_delete.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void formEdit(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<Employee> em=serviceEm.findAll();
        req.setAttribute("employees",em);
        try {
            req.getRequestDispatcher("/form_edit_employee.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        serviceEm.deleteEmployee(id);
        try {
            resp.sendRedirect("/furama?action=showFormEmployee&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void showFormSearch(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.getRequestDispatcher("/employee_find.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void searchByName(HttpServletRequest req, HttpServletResponse resp){
        String url = req.getParameter("searchByName");
        ArrayList<Employee> employee=serviceEm.searchByName(url);
        req.setAttribute("employees",employee);
        try {
            req.getRequestDispatcher("employee_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
