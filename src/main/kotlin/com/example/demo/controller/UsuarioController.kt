package com.example.demo.controller

import com.example.demo.model.Usuario
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

    @RestController // Avisando que é um controller
    @RequestMapping("/api/users") // Caminho para encontrar o usuario
    class UsuarioController {

        private val users = mutableListOf<Usuario>()  // Criar uma lista de usuario
        private var currentId: Long = 1 // Criar um Id para cada usuario

        @PostMapping // Criar um usuario
        @ResponseStatus(HttpStatus.CREATED) //
        fun cadastrarUsuario(@RequestBody newUser: Usuario): Usuario {
            newUser.id = currentId++
            users.add(newUser)
            return newUser
        }

        @GetMapping // Buscar o usuario
        fun listarUsuario(): List<Usuario> {
            return users
        }

        @PutMapping("/{id}") // Enviar a informação inteira apenas por atualizar uma parte dos dados
        fun atualizarUsuario(@PathVariable id: Long, @RequestBody updatedUser: Usuario): ResponseEntity<Usuario> {
            val user = users.find { it.id == id }
            return if (user != null) {
                user.nome = updatedUser.nome
                user.email = updatedUser.email
                user.senha = updatedUser.senha
                ResponseEntity.ok(user)
            } else {
                ResponseEntity.notFound().build()
            }
        }

        @DeleteMapping("/{id}") // Deletar o usuario
        fun deletarUsuario(@PathVariable id: Long): HttpStatus {
            val removed = users.removeIf { it.id == id }
            return if (removed) HttpStatus.OK else HttpStatus.NOT_FOUND
        }
    }
