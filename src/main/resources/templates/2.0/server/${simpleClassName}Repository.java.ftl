package ${basepackage};

import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.mawujun.repository.mybatis.IRepository;
import org.apache.ibatis.annotations.Mapper;

import ${basepackage}.${simpleClassName};
<#include "/java_copyright.include"/>

@Mapper
public interface ${simpleClassName}Repository extends IRepository<${simpleClassName}>{


}
