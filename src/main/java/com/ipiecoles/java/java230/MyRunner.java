package com.ipiecoles.java.java230;
import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.model.Technicien;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import com.ipiecoles.java.java230.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private TechnicienRepository technicienRepository;
    @Override
    public void run(String... strings) throws Exception {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.ASC, "matricule");
        List<Technicien> employes = technicienRepository.findAll();
        for(Employe  employe : employes){
            System.out.println(employe.toString());
        }
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}