While mentioning versions in maven dependencies it is recommended not to mention version numbers directly 
in dependency tag.
Instead write it separately using properties tag as shown below:
Maven has three life cycle:
1.clean
2.default
3.site
Each life cycle has multiple phases
ex: 
default life cycle has following phase compile,package,install.
Each phase has one or more plugin goal.
ex:
package phase has jar:jar plugin goal.

