package com.muxengressos.engresso.specifications;

import com.muxengressos.engresso.models.Egresso;
import com.muxengressos.engresso.models.dtos.RequestEgressoDto;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationTemplate {

    //tem tbm o @Or => vai pegar um ou outro e retornar
    @And(
        {@Spec(path = "cpf", spec = Like.class),
        @Spec(path = "email", spec = Like.class),
        @Spec(path = "userStatus", spec = Equal.class)
        })
    public interface EgressoSpec extends Specification<Egresso>{

    }
}
