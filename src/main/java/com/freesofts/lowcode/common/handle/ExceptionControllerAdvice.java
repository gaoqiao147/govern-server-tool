package com.freesofts.lowcode.common.handle;

import com.freesofts.common.response.BizResponseData;
import com.freesofts.common.response.result.types.IntegerBizResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description: </br>
 * date: 2020/6/30 17:01</br>
 *
 * @author Administrator</ br>
 * @since JDK 1.8
 */
@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BizResponseData exceptionHandler(Exception e){
        //发生异常进行日志记录，写入数据库或者其他处理
        log.error(e.getLocalizedMessage());
        e.printStackTrace();//打印堆栈信息，方便定位
        //如果是入参校验异常
        StringBuilder stringBuilder = new StringBuilder();
        if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException e1 = (MethodArgumentNotValidException) e;
            BindingResult result = e1.getBindingResult();
            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                errors.stream().map(p -> (FieldError) p).map(fieldError -> fieldError.getField() + ":" + fieldError.getDefaultMessage() + ",").forEach(stringBuilder::append);
            }
        }else if (e instanceof UnexpectedRollbackException){
            stringBuilder.append("操作失败，异常回滚。");
        } else {
            stringBuilder.append(e.getLocalizedMessage());
        }
        return IntegerBizResult.builder().value(0).message(stringBuilder.toString()).build().beEqualTo(1);
    }
}
