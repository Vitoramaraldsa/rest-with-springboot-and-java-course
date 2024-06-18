package br.com.vitor.mapper;


import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    //primeiro definimos dois objetos <O=ORIGEM,D=DESTINO>, o retorno do método é o destino (D).
    //Recebemos uma origem e retornamos uma classe do tipo<D>=Destino.
    public static <O,D> D parseObject(O origin, Class<D> destination){
        return  mapper.map(origin,destination);

    }


    //primeiro definimos dois objetos <O=ORIGEM,D=DESTINO>, o retorno do método é o destino (D).
    //Recebemos uma origem e retornamos uma classe do tipo<D>=Destino.
    public static <O,D> List<D> parseListObjects(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();
        for( O o : origin){
            destinationObjects.add(mapper.map(o,destination));
        }
        return  destinationObjects;

    }

}
