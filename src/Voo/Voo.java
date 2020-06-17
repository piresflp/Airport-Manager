package Voo;

import java.util.Objects;
import Aeroporto.Aeroporto;


public class Voo implements Cloneable{
    private String codVoo;
    private String codAeroportoDestino;

    public Voo (String codVoo, String codAeroportoDestino) throws Exception{
        try {
            setCodAeroportoDestino(codAeroportoDestino);
            setCodVoo(codVoo);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setCodAeroportoDestino(String codAeroportoDestino) throws Exception{
        if (codAeroportoDestino == null)
            throw new Exception("Codigo de Aeroporto nulo");
        this.codAeroportoDestino = codAeroportoDestino;
    }

    public void setCodVoo(String codVoo) throws Exception{
        if (codVoo == null || codVoo.length() != 3 )
            throw new Exception("Valor de código de voo inválido.");
        this.codVoo = codVoo;
    }

    public String getCodVoo() {
        return this.codVoo;
    }

    public String getCodAeroportoDestino() {
        return this.codAeroportoDestino;
    }

    @Override
    public String toString() {
        String ret = "Voo "+this.codVoo+":";
        ret += "\n Código do aeroporto de destino: "+this.codAeroportoDestino;
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj.getClass() != this.getClass())
            return false;
        if(this == obj)
            return true;

        Voo voo = (Voo) obj;

        if(!this.codVoo.equals(voo.codVoo))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int ret = 23;
        ret = ret * 7 + this.codVoo.hashCode();
        ret = ret * 7 + this.codAeroportoDestino.hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }

    public Voo(Voo modelo) throws Exception{
        if(modelo == null)
            throw new Exception("Modelo nulo.");
        this.codVoo = modelo.codVoo;
        this.codAeroportoDestino = modelo.codAeroportoDestino;
    }

    public Object clone(){
        Voo ret = null;
        try{
            ret = new Voo(this);
        }
        catch (Exception e) {}
        return ret;
    }
}
