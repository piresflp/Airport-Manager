package ListaAeroporto;
import Aeroporto.Aeroporto;
import ListaDuplamenteLigadaDesordenadaSemRepeticao.ListaDuplamenteLigadaDesordenadaSemRepeticao;
import Voo.Voo;

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
            if (codAeroporto.equals(aeroportoAtual.getInfo().getCodigo()))
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
        else
            super.insiraNoFim(aeroporto);
    }

    public void addVoo(String codEmbarque, String codDesembarque, int codVôo) throws Exception{
        if (existe(codDesembarque) == false || existe(codEmbarque) == false)
            throw new Exception("Aeroportos não existentes");
        Voo novoVoo = new Voo(codVôo, codDesembarque);
        No aeroportoAtual=this.primeiro;

        while (aeroportoAtual!=null)
        {
            if (codEmbarque.equals(aeroportoAtual.getInfo().getCodigo())) {
                aeroportoAtual.getInfo().adicionarVoo(novoVoo);
                break;
            }
            aeroportoAtual = aeroportoAtual.getProx();
        }
    }
    public String voosAeroporto(String codAeroporto){
        No aeroportoAtual=this.primeiro;

        while (aeroportoAtual!=null)
        {
            if (codAeroporto.equals(aeroportoAtual.getInfo().getCodigo())) {
                return aeroportoAtual.getInfo().toString();
            }
            aeroportoAtual = aeroportoAtual.getProx();
        }
        return aeroportoAtual.getInfo().toString();
    }

    public String todosVoosAeroportos(){
        No aeroportoAtual=this.primeiro;
        String ret = "";

        while (aeroportoAtual!=null)
        {
            ret += aeroportoAtual.getInfo().toString() + "\n";
            aeroportoAtual = aeroportoAtual.getProx();
        }
        return ret;
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
