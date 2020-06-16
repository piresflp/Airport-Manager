package Aeroporto;

import ListaDuplamenteLigadaDesordenadaSemRepeticao.ListaDuplamenteLigadaDesordenadaSemRepeticao;
import ListaDuplamenteLigadaDesordenada.ListaDuplamenteLigadaDesordenada;
import Voo.Voo;

public class Aeroporto implements Cloneable{
    protected String codigo;
    protected String cidade;
    protected ListaDuplamenteLigadaDesordenadaSemRepeticao<Voo> voos;

    public Aeroporto(String codigo, String cidade) throws Exception{
        this.setCodigo(codigo);
        this.setCidade(cidade);
        voos = new ListaDuplamenteLigadaDesordenadaSemRepeticao<Voo>();
    }

    public void adicionarVoo(Voo voo) throws Exception{
        if(voo == null)
            throw new Exception("Voo inválido.");
        if (voos.isVazia()) {
            //System.out.println(voo);
            voos.insiraNoInicio(voo);
            //System.out.println(voos);
        }
        else
            voos.insiraNoFim(voo);
    }

    public void removerVoo(int codVoo) throws Exception{
        if(codVoo < 0)
            throw new Exception("Voo inválido.");

        Voo vooARemover = new Voo(codVoo, "XXX");
        if(!this.voos.existe(vooARemover))
            throw new Exception("Voo inexistente.");
        this.voos.remova(vooARemover);
    }

    public String getCodigo(){
        return this.codigo;
    }

    public String getCidade(){
        return this.cidade;
    }

    public ListaDuplamenteLigadaDesordenada<Voo> getVoos(){
        ListaDuplamenteLigadaDesordenada<Voo> lista = null;
        try{
            lista = new ListaDuplamenteLigadaDesordenada<Voo>(this.voos);
        }catch(Exception e){}
        return lista;
    }

    public void setCodigo(String codigo) throws Exception{
        if(codigo == null || codigo.length() != 3)
            throw new Exception("Código de aeroporto inválido.");
        this.codigo = codigo;
    }

    public void setCidade(String cidade) throws Exception{
        if(cidade == null)
            throw new Exception("Cidade de aeroporto inválida.");
        this.cidade = cidade;
    }

    @Override
    public String toString(){
        String ret = "Aeroporto de "+this.cidade+":";
        ret += "\n Código: "+this.codigo;
        ret += "\n Voos: " + this.voos+ "\n";

        return ret;
    }

    @Override
    public int hashCode(){
        int ret = 23;
        ret = ret * 7 + this.codigo.hashCode();
        ret = ret * 7 + this.cidade.hashCode();
        ret = ret * 7 + this.voos.hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (this.getClass() != obj.getClass())
            return false;

        Aeroporto aeroporto = (Aeroporto) obj;
        if(!this.codigo.equals(aeroporto.codigo))
            return false;
        if(!this.cidade.equals(aeroporto.cidade))
            return false;
        if(!this.voos.equals(aeroporto.voos))
            return false;

        return true;
    }

    public Aeroporto(Aeroporto modelo) throws Exception{
        if(modelo == null)
            throw new Exception("Modelo inválido.");

        this.codigo = modelo.codigo;
        this.cidade = modelo.cidade;
        this.voos = modelo.voos;
    }

    public Object clone(){
        Aeroporto ret = null;
        try{
            ret = new Aeroporto(this);
        }catch(Exception e){}

        return ret;
    }
}
