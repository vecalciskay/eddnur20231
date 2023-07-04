package edu.nur.edd.dao;

import edu.nur.edd.listas.ListaDoble;

public class TestDao {
    public static void main(String[] args) {
        //FactoryDao factory = FactoryDao.getOrCreate();
        //PersonaDao dao = factory.newPersonaDao();
        PersonaDao dao = new PersonaDao();
        PersonaDto p = dao.getById(1);
        System.out.println(p);

        ListaDoble<PersonaDto> lista = dao.getAll();
        System.out.println(lista);

        p.setNombre("Pepe");
        dao.update(p);
/*
        dao.delete(3);

        PersonaDto nuevo =
                new PersonaDto(5,"McPato",159);
        dao.insert(nuevo);

         */
    }
}
