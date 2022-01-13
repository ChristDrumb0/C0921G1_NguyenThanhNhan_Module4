package vn.codegym.service;

import vn.codegym.model.MedicalDeclaration;

import java.util.List;


public interface IService {


    public MedicalDeclaration showDeclaredInfor();


    public MedicalDeclaration saveInfor(MedicalDeclaration object);
}
