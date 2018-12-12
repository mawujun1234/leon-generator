<#assign simpleClassNameFirstLower = simpleClassName?uncap_first> 
package ${basepackage}.service;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.mawujun.service.BaseService;

import lombok.extern.slf4j.Slf4j;


import ${basepackage}.${simpleClassName};
import ${basepackage}.repository.${simpleClassName}Repository;


<#include "/java_copyright.include"/>

@Service
@Transactional(propagation=Propagation.REQUIRED)
@Slf4j
public class ${simpleClassName}Service  extends BaseService<${simpleClassName}Repository, ${simpleClassName}>{


}
