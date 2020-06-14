package ListaDuplamenteLigadaDesordenadaSemRepeticao;
import ListaDuplamenteLigadaDesordenada.ListaDuplamenteLigadaDesordenada;

public class ListaDuplamenteLigadaDesordenadaSemRepeticao<X> extends ListaDuplamenteLigadaDesordenada<X> implements Cloneable{
    public ListaDuplamenteLigadaDesordenadaSemRepeticao(){
        super();
    }

    @Override
    public void insiraNoInicio(X x) throws Exception{
        if(this.existe(x))
            throw new Exception("Informação já existente.");
        super.insiraNoInicio(x);
    }

    @Override
    public void insiraNoFim(X x) throws Exception{
        if(this.existe(x))
            throw new Exception("Informação já existente.");
        super.insiraNoInicio(x);
    }

    public ListaDuplamenteLigadaDesordenadaSemRepeticao(ListaDuplamenteLigadaDesordenadaSemRepeticao<X> modelo) throws Exception {
        super(modelo);
    }

    public Object clone(){
        ListaDuplamenteLigadaDesordenadaSemRepeticao<X> ret = null;
        try{
            ret = new ListaDuplamenteLigadaDesordenadaSemRepeticao(this);
        }catch(Exception e){}

        return ret;
    }
}
