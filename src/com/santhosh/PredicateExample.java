package com.santhosh;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
//problem statement: given list of assets of different type find total of all assets and total of assets type stock only 
//and total of assets type bond only.
public class PredicateExample {
	/* Java 7 approach
	  This approach leads to duplication, lacks separation of concern.
	public static void totalAssets(List<Asset> assets) {
		int total = 0;
		for(Asset asset : assets) {
			total += asset.value;
		}
		
		System.out.println(total);
	}
	public static void totalStockAssets(List<Asset> assets) {
	    int total = 0;
	    for(Asset asset : assets) {
	      if(asset.type == Asset.AssetType.STOCK)
	        total += asset.value;
	    }
	    System.out.println(total);    
	}
	public static void totalBondAssets(List<Asset> assets) {
	    int total = 0;
	    for(Asset asset : assets) {
	      if(asset.type == Asset.AssetType.BOND)
	        total += asset.value;
	    }
	    System.out.println(total);    
	  } 
	  */
	
	//Java 8 approach
	
	public static void totalAssets(List<Asset> assets, Predicate<Asset> selector) {
		System.out.println(assets.stream()
			  .filter(selector)
			  .mapToInt(asset -> asset.value)
			  .sum());

	}
	
	
	
	public static void main(String[] args) {
		List<Asset> assets = Arrays.asList(new Asset(Asset.AssetType.STOCK, 100), 
				new Asset(Asset.AssetType.BOND, 200),
				new Asset(Asset.AssetType.STOCK, 300),
				new Asset(Asset.AssetType.BOND, 400));
		//We don't want to go this route.
		//totalAssets(assets);
		//totalStockAssets(assets);
		//totalBondAssets(assets);
		
		//In Java 8 we can use Predicate function as argument and specify type as required
		// This is known as strategy pattern
		totalAssets(assets, asset -> true);
		totalAssets(assets, asset -> asset.type == Asset.AssetType.STOCK);
		totalAssets(assets, asset -> asset.type == Asset.AssetType.BOND);
		
	
	}

}
