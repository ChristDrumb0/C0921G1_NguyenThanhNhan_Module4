package vn.codegym.repository;

import vn.codegym.model.MedicalDeclaration;

import java.util.List;


public interface IRepository {


    public MedicalDeclaration showDeclaredInfor();


    public MedicalDeclaration saveInfor(MedicalDeclaration object);

}
