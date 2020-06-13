package Voo;

import java.util.Objects;

import Aeroporto.Aeroporto;
public class Voo {
    private int codVoo;
    private int codProximoAeroporto;

    public Voo (int codVoo, int codProximoAeroporto) throws Exception{
        try {
            setCodProximoAeroporto(codProximoAeroporto);
            setCodVoo(codVoo);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setCodProximoAeroporto(int codProximoAeroporto) throws Exception{
        if (Aeroporto.voos.existe(codProximoAeroporto))
            throw new Exception("código de aeroporto inexistente");

        this.codProximoAeroporto = codProximoAeroporto;
    }

    public void setCodVoo(int codVoo) throws Exception{
        if (codVoo < 0)
            throw new Exception("valor negativo pra voo");
        this.codVoo = codVoo;
    }

    public int getCodProximoAeroporto() {
        return codProximoAeroporto;
    }

    public int getCodVoo() {
        return codVoo;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "codVoo=" + codVoo +
                ", codProximoAeroporto=" + codProximoAeroporto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Voo))
            return false;
        Voo voo = (Voo) o;
        return codVoo == voo.codVoo &&
                codProximoAeroporto == voo.codProximoAeroporto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codVoo, codProximoAeroporto);
    }
}
