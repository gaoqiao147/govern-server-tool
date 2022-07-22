package com.freesofts.lowcode.common.feign;

import com.freesofts.lowcode.common.depart.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Description: </br>
 * date: 2020/7/6 10:27</br>
 *
 * @author Administrator</   br>
 * @since JDK 1.8
 */

@FeignClient(value = "govern-support-service")
public interface SupportFeignService {

    /**
     * 根据组织id查询组织详情
     * @param id
     * @return
     */
    @GetMapping("/organization-anon/{id}")
    Organization getOrganizationById(@PathVariable("id") String id);


    /**
     * 根据行政区划获取用户id
     * @param administrativeCode
     * @param authCodes
     * @return
     */
    @GetMapping("/users-anon/area/auth")
    List<String> getUsersIdByAreaAuth(
		    @NotBlank(message = "行政编码不能为空") @RequestParam("administrativeCode") String administrativeCode,
		    @NotBlank(message = "权限代码不能为空") @RequestParam("authCodes") String authCodes);
}
