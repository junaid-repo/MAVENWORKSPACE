
  CREATE OR REPLACE PROCEDURE "DEV"."GETCOUNTRYDATA" (paramName  in varchar2,
                                           paramValue in varchar2,
                                           comparator in varchar2,
                                           
                                           countryDetails out clob,
                                           primConcat out varchar2,
                                           secConcat out varchar2,
                                           tertConcat out varchar2,
                                           retCode        out number,
                                           retErr         out varchar2) as

  masterQuery      varchar2(2000);
  comp             varchar2(20);
  CUR1             SYs_REFCURSOR;
  country          varchar2(2000);
  region           varchar2(2000);
  population       number;
  area             number;
  pop_density      number;
  coastline        number;
  net_migration    number;
  infant_mortality number;
  gdp              number;
  literacy         number;
  phones           number;
  arable           number;
  crops            number;
  other            number;
  climate          number;
  birthrate        number;
  deathrate        number;
  agriculture      number;
  industry         number;
  service          number;

  data varchar2(3000);

begin
  primConcat:='##';
  secConcat:='~~';
  tertConcat:='@@';
  countryDetails:='';

  if (comparator = 'more than') then
    comp := '>';
  elsif (comparator = 'less than') then
    comp := '<';
  elsif (comparator = 'equals') then
    comp := '=';
  end if;

  masterQuery := 'select cf.country,
       cf.region,
       cf.population,
       cf.area,
       cf.pop_density,
       cf.coastline,
       cf.net_migration,
       cf.infant_mortality,
       cf.gdp,
       cf.literacy,
       cf.phones,
       cf.arable,
       cf.crops,
       cf.other,
       cf.climate,
       cf.birthrate,
       cf.deathrate,
       cf.agriculture,
       cf.industry,
       cf.service from dev.countries_full_details cf where cf.' ||
                 paramName || ' ' || comp || paramValue;

  OPEN CUR1 FOR masterQuery;
  LOOP
    FETCH CUR1
      INTO country,
           region,
           population,
           area,
           pop_density,
           coastline,
           net_migration,
           infant_mortality,
           gdp,
           literacy,
           phones,
           arable,
           crops,
           other,
           climate,
           birthrate,
           deathrate,
           agriculture,
           industry,
           service;
  
    EXIT WHEN CUR1%NOTFOUND;
  
    data := trim(country) || '@@country~~' || trim(region) || '@@region~~' || population || '@@population~~' || area || '@@area~~' ||
            pop_density || '@@pop_density~~' || coastline || '@@coastline~~' || net_migration || '@@net_migration~~' ||
            infant_mortality || '@@infant_mortality~~' || gdp || '@@gdp~~' || literacy || '@@literacy~~' ||
            phones || '@@phones~~' || arable || '@@arable~~' || crops || '@@crops~~' || other || '@@other~~' ||
            climate || '@@climate~~' || birthrate || '@@birthrate~~' || deathrate || '@@deathrate~~' ||
            agriculture || '@@agriculture~~' || industry || '@@industry~~' || service|| '@@service';
            
  countryDetails:=countryDetails||data||'##';          
            
            
  END LOOP;

  CLOSE CUR1;
  countryDetails:= SUBSTR(countryDetails, 0, LENGTH(countryDetails) - 2);

exception

  when others then
    retcode := sqlcode;
    retErr  := sqlerrm;
end;
