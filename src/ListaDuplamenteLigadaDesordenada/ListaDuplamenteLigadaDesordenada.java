package ListaDuplamenteLigadaDesordenada;

import java.lang.reflect.Method;

public class ListaDuplamenteLigadaDesordenada<X>
{
    protected class No
    {
        private No ante;
        private X info;
        private No prox;

        public No(No a, X i, No p)
        {
            this.ante = a;
            this.info = i;
            this.prox = p;
        }
        public No(X info)
        {
            this.ante = null;
            this.info = info;
            this.prox = null;
        }

        public X getInfo()
        {
            return this.info;
        }

        public No getProx()
        {
            return this.prox;
        }

        public No getAnte()
        {
            return this.ante;
        }

        public void setAnte(No a)
        {
            this.ante = a;
        }
        public void setProx(No p)
        {
            this.prox = p;
        }
        public void setInfo(X i)
        {
            this.info = i;
        }
    }

    protected No primeiro, ultimo;

    public ListaDuplamenteLigadaDesordenada()
    {
        this.primeiro=this.ultimo=null;
    }

    protected X meuCloneDeX(X x)
    {
        X ret = null;
        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method method = classe.getMethod("clone", tipoDosParms);
            Object[] parms = null;
            ret = (X)method.invoke(x, parms);
        }
        catch (Exception ex)
        { }
        return ret;
    }

    protected X tryGetClone(X x)
    {
        X ret = null;
        if(x instanceof Cloneable)
            ret = meuCloneDeX(x);
        else
            ret = x;
        return ret;
    }

    public void insiraNoInicio(X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        X inserir=null;
        if (i instanceof Cloneable)
            inserir = meuCloneDeX (i);
        else
            inserir = i;

        this.primeiro = new No (null,inserir,this.primeiro);

        if (this.primeiro.getProx()!=null)
            this.primeiro.getProx().setAnte (this.primeiro);

        this.primeiro.setAnte (null);

        if (this.ultimo==null)
            this.ultimo=this.primeiro;
    }

    public void insiraNoFim(X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        X inserir=null;
        if (i instanceof Cloneable)
            inserir = meuCloneDeX (i);
        else
            inserir = i;

        if (this.ultimo==null) // && this.primeiro==null
        {
            this.ultimo   = new No (inserir);
            this.primeiro = this.ultimo;
        }
        else
        {
            this.ultimo.setProx (new No (this.ultimo,inserir,null));
            this.ultimo = this.ultimo.getProx();
        }
    }

    public void removaDoInicio() throws Exception
    {
        if (this.primeiro==null /*&& this.ultimo==null*/)
            throw new Exception ("Nada a remover");

        this.primeiro = this.primeiro.getProx();

        if (this.primeiro==null) //so tinha 1 elemento
            this.ultimo = null;
        else
            this.primeiro.setAnte (null);
    }

    public void removaDoFim() throws Exception
    {
        if (this.primeiro==null/*&&this.ultimo==null*/)
            throw new Exception ("Nada a remover");

        this.ultimo = this.ultimo.getAnte();

        if (this.ultimo==null)
            this.primeiro=null;
        else
            this.ultimo.setProx(null);
    }

    public void remova(X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        if (this.primeiro==null/*&&this.ultimo==null*/)
            throw new Exception ("Lista vazia");

        if (i.equals(this.primeiro.getInfo()))
        {
            this.primeiro = this.primeiro.getProx();

            if (this.primeiro==null) //so tinha 1 elemento
                this.ultimo = null;
            else
                this.primeiro.setAnte (null);

            return;
        }

        No atual=this.primeiro;

        for(;;) // FOR EVER (repete até Exception ou return)
        {
            if (atual==null)
                throw new Exception ("Informacao inexistente");

            if (i.equals(atual.getInfo()))
            {
                if (atual==this.primeiro)
                {
                    this.primeiro = this.primeiro.getProx();

                    if (this.primeiro==null) //so tinha 1 elemento
                        this.ultimo = null;
                    else
                        this.primeiro.setAnte (null);

                    return;
                }

                if (atual==this.ultimo)
                {
                    this.ultimo = this.ultimo.getAnte();

                    if (this.ultimo==null)
                        this.primeiro=null;
                    else
                        this.ultimo.setProx(null);

                    return;
                }

                atual.getAnte().setProx(atual.getProx());
                atual.getProx().setAnte(atual.getAnte());
                return;
            }

            atual=atual.getProx();
        }
    }

    public ListaDuplamenteLigadaDesordenada<X> inversao ()
    {
        ListaDuplamenteLigadaDesordenada<X> ret =
                new ListaDuplamenteLigadaDesordenada<X> ();

        for (No atual=this.primeiro; atual!=null; atual=atual.getProx())
        {

            ret.primeiro = new No (null,atual.getInfo(),ret.primeiro);

            if (ret.primeiro.getProx()!=null)
                ret.primeiro.getProx().setAnte (ret.primeiro);

            ret.primeiro.setAnte (null);

            if (ret.ultimo==null)
                ret.ultimo=ret.primeiro;
        }

        return ret;
    }

    public boolean existe(X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        No atual=this.primeiro;

        while (atual!=null)
        {
            if (i.equals(atual.getInfo()))
                return true;

            atual = atual.getProx();
        }

        return false;
    }

    public int getQtd ()
    {
        No  atual=this.primeiro;
        int ret  =0;

        while (atual!=null)
        {
            ret++;
            atual = atual.getProx();
        }

        return ret;
    }

    public X getDoInicio () throws Exception
    {
        if (this.primeiro==null/*&&this.fim==null)*/)
            throw new Exception ("Nada a obter");

        X ret = this.primeiro.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX (ret);

        return ret;
    }

    public X getDoFim () throws Exception
    {
        if (this.primeiro==null/*&&this.ultimo==null)*/)
            throw new Exception ("Nada a obter");

        X ret = this.ultimo.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX (ret);

        return ret;
    }

    public boolean isVazia ()
    {
        return this.primeiro==null;
    }

    public String toString()
    {
        String ret="[";

        No atual=this.primeiro;

        while (atual!=null)
        {
            ret=ret+atual.getInfo();

            if (atual!=this.ultimo)
                ret=ret+",";

            atual=atual.getProx();
        }

        return ret+"]";
    }

    public int hashCode ()
    {
        int ret=7;

        for (No atual=this.primeiro;
             atual!=null;
             atual=atual.getProx())
            ret = 23*ret + atual.getInfo().hashCode();

        if (ret<0) ret = -ret;

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass()!=obj.getClass())
            return false;

        ListaDuplamenteLigadaDesordenada<X> lista =
                (ListaDuplamenteLigadaDesordenada<X>)obj;

        No atualThis =this .primeiro;
        No atualLista=lista.primeiro;

        while (atualThis!=null && atualLista!=null)
        {
            if (!atualThis.getInfo().equals(atualLista.getInfo()))
                return false;

            atualThis  = atualThis .getProx();
            atualLista = atualLista.getProx();
        }

        if (atualThis!=null)
            return false;

        if (atualLista!=null)
            return false;

        return true;
    }

    public ListaDuplamenteLigadaDesordenada (ListaDuplamenteLigadaDesordenada<X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.primeiro==null)
            return;

        this.primeiro = new No (modelo.primeiro.getInfo());

        No atualDoThis   = this  .primeiro;
        No atualDoModelo = modelo.primeiro.getProx();

        while (atualDoModelo!=null)
        {
            atualDoThis.setProx (new No (atualDoThis,atualDoModelo.getInfo(),null));
            atualDoThis   = atualDoThis  .getProx ();
            atualDoModelo = atualDoModelo.getProx ();
        }

        this.ultimo = atualDoThis;
    }

    public Object clone ()
    {
        ListaDuplamenteLigadaDesordenada<X> ret=null;

        try
        {
            ret = new ListaDuplamenteLigadaDesordenada (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }

}