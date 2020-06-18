package com.stockers.stockers.user.controller;

import com.stockers.stockers.user.domain.User;
import com.stockers.stockers.user.dto.PasswordDto;
import com.stockers.stockers.user.dto.UserDto;
import com.stockers.stockers.user.mapper.UserMapper;
import com.stockers.stockers.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(tags = "users")
public class UserController {

    private UserService userService;
    private User user;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @ApiOperation(value = "Listado de usuarios", notes = "Devuelve un listado de usuarios")
    public ResponseEntity<List<User>> users(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/{userId}")
    @ApiOperation(value = "Busca un usuario", notes = "Devuelve un usuario segun ID")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
        User user = userService.findById(userId);
        UserDto userDto = UserMapper.modelToDto(user);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping()
    @ApiOperation(value = "Crea un usuario", notes = "Crea un usuario y lo devuelve")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto){
        User user = UserMapper.dtoToModel(userDto);
        return ResponseEntity.ok((userService.create(user)));
    }
    @PutMapping(path = "/{userId}")
    @ApiOperation(value = "Actualiza un usuario", notes = "Actualiza un usuario y lo devuelve")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody @Valid UserDto userDto){
        User user = UserMapper.dtoToModel(userDto);
        return ResponseEntity.ok((userService.update(user)));
    }
    @PutMapping(path = "/{userId}/update_password")
    public void updatePassword(@PathVariable Integer userId, @RequestBody @Valid PasswordDto passwordDto){
        User user = UserMapper.passwordToUser(userId, passwordDto);
        userService.updatePassword(user);
    }

    @DeleteMapping("/{ID de usuario}")
    @ApiOperation(value = "Eliminar usuario", notes = "Servicio para eliminar un usuario")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "usuario eliminado correctamente"),
            @ApiResponse(code = 404, message = "usuario no encontrado") })
    public void removeUser (@PathVariable("ID de usuario") Integer userId) {
        User user = this.userService.findById(userId);
        if (user != null){
            this.userService.delete(user);

        }
    }

}
