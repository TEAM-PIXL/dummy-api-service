module PIXL.POS.main {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;
    requires spring.data.commons;
    requires spring.webmvc;
    requires spring.core;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.tx;
    requires spring.orm;
    requires spring.jdbc;
    requires java.sql;
    requires spring.security.config;
    requires spring.security.web;
    requires io.swagger.v3.oas.models;
    requires io.swagger.v3.oas.annotations;
    requires org.springdoc.openapi.common;

    opens teampixl.com;
    opens teampixl.com.models;
    opens teampixl.com.models.tools;
    opens teampixl.com.global.exceptions;
    opens teampixl.com.controllers;
    opens teampixl.com.services;

    exports teampixl.com;
    exports teampixl.com.models;
    exports teampixl.com.models.tools;
    exports teampixl.com.global.exceptions;
    exports teampixl.com.controllers;
    exports teampixl.com.services;
}
