/**
 * 
 */
package catalyst.automation.pages;
class BasePageValidator<M extends BasePageElementMap>
{
    
	private M Map1;

	BasePageValidator(M Map1)
	{
		
		this.Map1 =  Map1;
	}
	
	public M getMap()
	{
		
		return  Map1;
	}
	
	
	
}

