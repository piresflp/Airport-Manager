package Voo;

import java.util.Objects;
import Aeroporto.Aeroporto;


public class Voo implements Cloneable{
    private int codVoo;
    private String codAeroportoDestino;

    public Voo (int codVoo, String codAeroportoDestino) throws Exception{
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
        this.codAeroportoDestino = codAeroportoDestino;
    }

    public void setCodVoo(int codVoo) throws Exception{
        if (codVoo <= 0)
            throw new Exception("Valor de código de voo inválido.");
        this.codVoo = codVoo;
    }

    public int getCodVoo() {
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

        if(this.codVoo != voo.codVoo)
            return false;
        if(!this.codAeroportoDestino.equals(voo.codAeroportoDestino))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int ret = 23;
        ret = ret * 7 + this.codVoo;
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

    public Object clone(Voo modelo){
        Voo ret = null;
        try{
            ret = new Voo(this);
        }catch (Exception e){}
        return ret;
    }
}
