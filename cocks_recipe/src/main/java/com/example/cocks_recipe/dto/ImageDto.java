package com.example.cocks_recipe.dto;





public class ImageDto {
        private String id;
        private String fileName;
        private String downloadUrl;


        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getFileName() {
                return fileName;
        }

        public void setFileName(String fileName) {
                this.fileName = fileName;
        }

        public String getDownloadUrl() {
                return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
                this.downloadUrl = downloadUrl;
        }
}