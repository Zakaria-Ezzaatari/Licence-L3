/**
 * PairesGen
 */
public class PairesGen <E,S>
{
    private E el1;
    private S el2;

    PairesGen (E obj1,S obj2)
    {
        this.el1=obj1;
        this.el2=obj2;
    }


    public void setEl1(E obj1)
    {
        this.el1=obj1;
    }

    public void setEl2(S obj2)
    {
        this.el2=obj2;
    }


    public E getEl1()
    {
        return this.el1;
    }

    public S getEl2()
    {
        return this.el2;
    }
}