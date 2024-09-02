/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.bigcorp.pokemon.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.bigcorp.pokemon.model.Type;
 
/**
 *
 * @author Utilisateur
 */
public class AttaqueDTOTest {

     public AttaqueDTOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class AttaqueDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        AttaqueDTO instance = new AttaqueDTO();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class AttaqueDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        AttaqueDTO instance = new AttaqueDTO();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class AttaqueDTO.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        AttaqueDTO instance = new AttaqueDTO();
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNom method, of class AttaqueDTO.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "";
        AttaqueDTO instance = new AttaqueDTO();
        instance.setNom(nom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class AttaqueDTO.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        AttaqueDTO instance = new AttaqueDTO();
        Type expResult = null;
        Type result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class AttaqueDTO.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        Type type = null;
        AttaqueDTO instance = new AttaqueDTO();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPointsDegats method, of class AttaqueDTO.
     */
    @Test
    public void testGetPointsDegats() {
        System.out.println("getPointsDegats");
        AttaqueDTO instance = new AttaqueDTO();
        Integer expResult = null;
        Integer result = instance.getPointsDegats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPointsDegats method, of class AttaqueDTO.
     */
    @Test
    public void testSetPointsDegats() {
        System.out.println("setPointsDegats");
        Integer pointsDegats = null;
        AttaqueDTO instance = new AttaqueDTO();
        instance.setPointsDegats(pointsDegats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}