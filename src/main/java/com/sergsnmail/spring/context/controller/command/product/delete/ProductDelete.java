package com.sergsnmail.spring.context.controller.command.product.delete;

import com.sergsnmail.spring.context.controller.command.Command;

public class ProductDelete extends Command<ProductDeleteParam> {

    private ProductDelete(ProductDeleteParam deleteParam) {
        this.parameter = deleteParam;
    }

    public static ProductDelete.DeleteBuilder builder () {
        return new ProductDelete.DeleteBuilder();
    }

    public static class DeleteBuilder {
        private long id;

        public ProductDelete.DeleteBuilder setId(long id) {
            this.id = id;
            return this;
        }


        public ProductDelete build(){
            ProductDeleteParam deleteParam = new ProductDeleteParam();
            deleteParam.setId(this.id);
            return new ProductDelete(deleteParam);
        }
    }
}
