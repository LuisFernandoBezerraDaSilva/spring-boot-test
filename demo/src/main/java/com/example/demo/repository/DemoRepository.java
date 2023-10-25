package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Usuario;

public interface DemoRepository extends JpaRepository<Usuario, Long> {
}