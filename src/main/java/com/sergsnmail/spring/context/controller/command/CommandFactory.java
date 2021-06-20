package com.sergsnmail.spring.context.controller.command;

import com.sergsnmail.spring.context.controller.command.product.avg.ProductAvg;
import com.sergsnmail.spring.context.controller.command.product.create.ProductCreate;
import com.sergsnmail.spring.context.controller.command.product.delete.ProductDelete;
import com.sergsnmail.spring.context.controller.command.product.list.ProductList;
import com.sergsnmail.spring.context.controller.command.product.read.ProductRead;
import com.sergsnmail.spring.context.controller.command.product.update.ProductUpdate;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс создания команды из строки
 * Формат строки:
 *      /[имя_команды_без_пробелов][пробел][-имя_параметра_1_без_пробелов]=[значение_параметра_1_без_пробелов][;][...]
 *      [-имя_параметра_N_без_пробелов]=[значение_параметра_N_без_пробелов]
 */
public class CommandFactory {
    public static Command create(String cmd) {
        String[] cmdParam = cmd.split(" ",2);
        Map<String, String> params = createParams(cmdParam);;
        if ("/create".equals(cmdParam[0])){
            if (!params.isEmpty()) {
                return ProductCreate.builder()
                        .setId(Long.parseLong(params.get("-id")))
                        .setTitle(params.get("-title"))
                        .setCost(Float.parseFloat((params.get("-cost"))))
                        .build();
            }
        } else if ("/read".equals(cmdParam[0])){
            if (!params.isEmpty()) {
                return ProductRead.builder()
                        .setId(Long.parseLong(params.get("-id")))
                        .build();
            }
        } else if ("/update".equals(cmdParam[0])){
            if (!params.isEmpty()) {
                return ProductUpdate.builder()
                        .setId(Long.parseLong(params.get("-id")))
                        .setTitle(params.get("-title"))
                        .setCost(Float.parseFloat((params.get("-cost"))))
                        .build();
            }
        } else if ("/delete".equals(cmdParam[0])){
            if (!params.isEmpty()) {
                return ProductDelete.builder()
                        .setId(Long.parseLong(params.get("-id")))
                        .build();
            }
        } else if ("/avg_cost".equals(cmdParam[0])) {
            return new ProductAvg();
        } else if ("/list".equals(cmdParam[0])){
            return new ProductList();
        }
        return null;
    }

    private static Map<String, String> createParams(String[] paramStr) {
        HashMap<String, String> params = new HashMap<>();
        if (paramStr.length > 1) {
            String[] paramsArr = paramStr[1].split(";");
            for (String p : paramsArr) {
                String[] keyValue = p.split("=");
                params.put(keyValue[0], keyValue[1]);
            }
        }
        return  params;
    }
}
