package com.sergsnmail.spring.context.controller.command.product.read;

import com.sergsnmail.spring.context.controller.command.Command;

public class ProductRead extends Command<ProductReadParam> {

    private ProductRead(ProductReadParam createParam) {
        this.parameter = createParam;
    }

    public static ProductRead.ReadBuilder builder () {
        return new ProductRead.ReadBuilder();
    }

    public static class ReadBuilder {
        private long id;

        public ProductRead.ReadBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public ProductRead build(){
            ProductReadParam readParam = new ProductReadParam();
            readParam.setId(this.id);
            return new ProductRead(readParam);
        }
    }

}
