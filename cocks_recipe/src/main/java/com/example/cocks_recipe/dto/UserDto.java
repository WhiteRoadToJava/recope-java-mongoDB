package com.example.cocks_recipe.dto;

import lombok.Data;


public class UserDto {
        private String id;
        private String username;


        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }
}