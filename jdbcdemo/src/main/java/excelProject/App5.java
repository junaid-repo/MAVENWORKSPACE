package excelProject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App5 implements Runnable {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String megaData ="Algeria@@country~~NORTHERN AFRICA@@region~~32930091@@population~~2381740@@area~~13.8@@pop_density~~.04@@coastline~~-.39@@net_migration~~31@@infant_mortality~~6000@@gdp~~70@@literacy~~78.1@@phones~~3.22@@arable~~.25@@crops~~96.53@@other~~1@@climate~~17.14@@birthrate~~4.61@@deathrate~~.101@@agriculture~~.6@@industry~~.298@@service##Argentina@@country~~LATIN AMER. & CARIB@@region~~39921833@@population~~2766890@@area~~14.4@@pop_density~~.18@@coastline~~.61@@net_migration~~15.18@@infant_mortality~~11200@@gdp~~97.1@@literacy~~220.4@@phones~~12.31@@arable~~.48@@crops~~87.21@@other~~3@@climate~~16.73@@birthrate~~7.55@@deathrate~~.095@@agriculture~~.358@@industry~~.547@@service##Australia@@country~~OCEANIA@@region~~20264082@@population~~7686850@@area~~2.6@@pop_density~~.34@@coastline~~3.98@@net_migration~~4.69@@infant_mortality~~29000@@gdp~~100@@literacy~~565.5@@phones~~6.55@@arable~~.04@@crops~~93.41@@other~~1@@climate~~12.14@@birthrate~~7.51@@deathrate~~.038@@agriculture~~.262@@industry~~.7@@service##Brazil@@country~~LATIN AMER. & CARIB@@region~~188078227@@population~~8511965@@area~~22.1@@pop_density~~.09@@coastline~~-.03@@net_migration~~29.61@@infant_mortality~~7600@@gdp~~86.4@@literacy~~225.3@@phones~~6.96@@arable~~.9@@crops~~92.15@@other~~2@@climate~~16.56@@birthrate~~6.17@@deathrate~~.084@@agriculture~~.4@@industry~~.516@@service##Canada@@country~~NORTHERN AMERICA@@region~~33098932@@population~~9984670@@area~~3.3@@pop_density~~2.02@@coastline~~5.96@@net_migration~~4.75@@infant_mortality~~29800@@gdp~~97@@literacy~~552.2@@phones~~4.96@@arable~~.02@@crops~~95.02@@other~~@@climate~~10.78@@birthrate~~7.8@@deathrate~~.022@@agriculture~~.294@@industry~~.684@@service##China@@country~~ASIA (EX. NEAR EAST)@@region~~1313973713@@population~~9596960@@area~~136.9@@pop_density~~.15@@coastline~~-.4@@net_migration~~24.18@@infant_mortality~~5000@@gdp~~90.9@@literacy~~266.7@@phones~~15.4@@arable~~1.25@@crops~~83.35@@other~~1.5@@climate~~13.25@@birthrate~~6.97@@deathrate~~.125@@agriculture~~.473@@industry~~.403@@service##Congo. Dem. Rep.@@country~~SUB-SAHARAN AFRICA@@region~~62660551@@population~~2345410@@area~~26.7@@pop_density~~0@@coastline~~0@@net_migration~~94.69@@infant_mortality~~700@@gdp~~65.5@@literacy~~.2@@phones~~2.96@@arable~~.52@@crops~~96.52@@other~~2@@climate~~43.69@@birthrate~~13.27@@deathrate~~.55@@agriculture~~.11@@industry~~.34@@service##Greenland@@country~~NORTHERN AMERICA@@region~~56361@@population~~2166086@@area~~0@@pop_density~~2.04@@coastline~~-8.37@@net_migration~~15.82@@infant_mortality~~20000@@gdp~~@@literacy~~448.9@@phones~~0@@arable~~0@@crops~~100@@other~~1@@climate~~15.93@@birthrate~~7.84@@deathrate~~@@agriculture~~@@industry~~@@service##India@@country~~ASIA (EX. NEAR EAST)@@region~~1095351995@@population~~3287590@@area~~333.2@@pop_density~~.21@@coastline~~-.07@@net_migration~~56.29@@infant_mortality~~2900@@gdp~~59.5@@literacy~~45.4@@phones~~54.4@@arable~~2.74@@crops~~42.86@@other~~2.5@@climate~~22.01@@birthrate~~8.18@@deathrate~~.186@@agriculture~~.276@@industry~~.538@@service##Kazakhstan@@country~~C.W. OF IND. STATES@@region~~15233244@@population~~2717300@@area~~5.6@@pop_density~~0@@coastline~~-3.35@@net_migration~~29.21@@infant_mortality~~6300@@gdp~~98.4@@literacy~~164.1@@phones~~7.98@@arable~~.05@@crops~~91.97@@other~~4@@climate~~16@@birthrate~~9.42@@deathrate~~.067@@agriculture~~.386@@industry~~.547@@service##Russia@@country~~C.W. OF IND. STATES@@region~~142893540@@population~~17075200@@area~~8.4@@pop_density~~.22@@coastline~~1.02@@net_migration~~15.39@@infant_mortality~~8900@@gdp~~99.6@@literacy~~280.6@@phones~~7.33@@arable~~.11@@crops~~92.56@@other~~@@climate~~9.95@@birthrate~~14.65@@deathrate~~.054@@agriculture~~.371@@industry~~.575@@service##Sudan@@country~~SUB-SAHARAN AFRICA@@region~~41236378@@population~~2505810@@area~~16.5@@pop_density~~.03@@coastline~~-.02@@net_migration~~62.5@@infant_mortality~~1900@@gdp~~61.1@@literacy~~16.3@@phones~~6.83@@arable~~.18@@crops~~92.99@@other~~2@@climate~~34.53@@birthrate~~8.97@@deathrate~~.387@@agriculture~~.203@@industry~~.41@@service##United States@@country~~NORTHERN AMERICA@@region~~298444215@@population~~9631420@@area~~31@@pop_density~~.21@@coastline~~3.41@@net_migration~~6.5@@infant_mortality~~37800@@gdp~~97@@literacy~~898@@phones~~19.13@@arable~~.22@@crops~~80.65@@other~~3@@climate~~14.14@@birthrate~~8.26@@deathrate~~.01@@agriculture~~.204@@industry~~.787@@service";
		String megaDataArr[] = megaData.split("##");
		List<List<Map>> superList  = new ArrayList<>();

		for (int i = 0; i < megaDataArr.length; i++) {
			// System.out.println(megaDataArr[i]);

			String dataArr[] = megaDataArr[i].split("~~");

			List<Map> listOfMaps = new ArrayList<>();

			for (int j = 0; j < dataArr.length; j++) {
				String tempData = dataArr[j];
				// System.out.println(tempData);

				String arr[] = tempData.split("@@");
				Map<String, String> retMap = new HashMap<>();

				try {
					if (arr[0] != null && arr[1] != null)
						retMap.put(arr[1], arr[0]);
					listOfMaps.add(retMap);
				} catch (Exception e) {
					e.printStackTrace();

				}
				// System.out.println(retMap);
			}
			//System.out.println(listOfMaps);
			superList.add(listOfMaps);
		}
		System.out.println(superList);

	}

	public void run() {

		App5 td = new App5();
		Thread thread = new Thread(td);

		try {

			for (int j = 1; j < 50; j++) {
				thread.sleep(300);
				System.out.println("INside run method " + j);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
