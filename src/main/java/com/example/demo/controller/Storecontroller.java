package.com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Store;
import com.example.demo.service.Storeservice;
@RestController
public class Storecontroller{
    @Autowired
    Storeservice src;
    @PostMapping("/post")
    public Store postData(@RequestBody Store st){
        return src.savedata(st);
    }
    @GetMapping("/getting")
    public List<Store> getData(){
        return src.retdata();
    }
    @GetMapping("/getid/{id}")
    public Store sepData(@PathVariable Long id){
        return src.indData(id);

    }
    @PutMapping("/update/{id}")
    public Store updateData(@PathVariable int id,@RequestBody Store st){
        return src.updat(id,st);
    }
    @DeleteMapping("/delete/{id}")
    public void del(@PathVariable Long id){
         src.delete(id);
    }
}