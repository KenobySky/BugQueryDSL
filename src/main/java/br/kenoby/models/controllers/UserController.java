package br.kenoby.models.controllers;

import br.kenoby.models.QUser;
import br.kenoby.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author André Lopes
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = {"/sys-admin/search"}, method = RequestMethod.GET)
    public ResponseEntity<Object> search() {

        String keyword = "user";

        QUser user = QUser.user;

        BooleanExpression predicateKeywordSearch
                = user.username.contains(keyword)
                        .or(user.tunnel.nomeEmpresa.contains(keyword));

        return new ResponseEntity<>(repository.findAll(predicateKeywordSearch), HttpStatus.OK);

    }

}
