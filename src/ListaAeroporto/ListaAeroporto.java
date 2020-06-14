package ListaAeroporto;
import Aeroporto.Aeroporto;
import ListaDuplamenteLigadaDesordenadaSemRepeticao.ListaDuplamenteLigadaDesordenadaSemRepeticao;

public class ListaAeroporto  extends ListaDuplamenteLigadaDesordenadaSemRepeticao<Aeroporto>{

    public ListaAeroporto(){
        super();
    }

    public boolean existe(String codAeroporto) throws Exception {
        if (codAeroporto == null)
            throw new Exception("variavel nula");

        No aeroportoAtual=this.primeiro;

        while (aeroportoAtual!=null)
        {
            if (codAeroporto == aeroportoAtual.getInfo().getCodigo())
                return true;

            aeroportoAtual = aeroportoAtual.getProx();
        }

        return false;
    }

    public void addAeroporto(Aeroporto aeroporto) throws Exception{
        if (aeroporto == null)
            throw new Exception("aeroporto nulo");
        if (super.isVazia())
            super.insiraNoInicio(aeroporto);
        super.insiraNoFim(aeroporto);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
