package com.sergsnmail.spring.context.controller.command.product.update;

import com.sergsnmail.spring.context.controller.command.Command;

public class ProductUpdate extends Command<ProductUpdateParam> {

    private ProductUpdate(ProductUpdateParam updateParam) {
        this.parameter = updateParam;
    }

    public static ProductUpdate.UpdateBuilder builder () {
        return new ProductUpdate.UpdateBuilder();
    }

    public static class UpdateBuilder {
        private long id;
        private String title;
        private float cost;

        public ProductUpdate.UpdateBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public ProductUpdate.UpdateBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductUpdate.UpdateBuilder setCost(float cost) {
            this.cost = cost;
            return this;
        }

        public ProductUpdate build(){
            ProductUpdateParam updateParam = new ProductUpdateParam();
            updateParam.setId(this.id);
            updateParam.setTitle(this.title);
            updateParam.setCost(this.cost);
            return new ProductUpdate(updateParam);
        }
    }
}
