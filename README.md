# How to register DCore?

```
@Override 
public void onEnable() {
 DCore.RegisterDCore(Plugin main); 
}
```
How to remove some class you don't you?

```
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version>
                <configuration>
                    <filters>
                        <filter>
                            <artifact>*:*</artifact>
                            <excludes>
                                <exclude>net/danh/dcore/Utils/Progress*</exclude>
                                <exclude>net/danh/dcore/Utils/Items*</exclude>
                                <exclude>net/danh/dcore/List/Contain*</exclude>
                                <exclude>net/danh/dcore/Events/EnchantItemEvent*</exclude>
                                <exclude>net/danh/dcore/Enchant/Lore*</exclude>
                            </excludes>
                        </filter>
                    </filters>
                </configuration>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <createDependencyReducedPom>false</createDependencyReducedPom>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```

[![](https://jitpack.io/v/D-x-Z/DCore.svg)](https://jitpack.io/#D-x-Z/DCore)

[![javadocs](https://img.shields.io/badge/JavaDocs-Active-blue?style="badge)](https://d-x-z.github.io/DCore/) <br>