# HAA
Hero Adventure Addon. This is an example addon for the example project, [HeroAdventure](https://github.com/HackusatePvP/HeroAdventure).

## Addons
Addons are effectively DLC's. It allows you to add additional content to a game without modifying the main release source.
It also allows the community to develop third party modifications for the game.

Addons are placed in the 'addons' folder which is inside the 'game' folder.

## Setup
You will need the RenJava framework as a dependency. If you need to modify existing content in the main game you will need to add the main game as a dependency.
You will also have to add any addons this addon may use as a dependency as well.
```xml
<dependencies>
    <!--This is the main RenJava framework. Note, you do not need this if your main game is a dependency (unless you want to see source code documentation).-->
    <dependency>
        <groupId>me.piitex</groupId>
        <artifactId>RenJava</artifactId>
        <version>0.1.109-beta</version>
    </dependency>
    <!-- This is the main game for this example. Note if you have this you do not need the dependency above.-->
    <dependency>
        <groupId>me.piitex.game</groupId>
        <artifactId>HeroAdventure</artifactId>
        <version>1.0-SNAPSHOT</version>
        
        <!-- If you want to use main framework and the game as dependencies, you need to add exclusions. IF YOU ARE NOT PLEASE REMOVE THE FOLLOWING LINES!!! -->
        <exclusion>
            <groupId>me.piitex</groupId>
            <artifactId>RenJava</artifactId>
        </exclusion>
    </dependency>

    <!-- This is an addon which this example could need. (This doesn't actually exist) -->
    <dependency>
        <groupId>me.piitex.game</groupId>
        <artifactId>SomeAddon</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

First create a class which contains the framework implementation.

```java
import me.piitex.renjava.addons.Addon;

public class MyAddon extends Addon {
    
    public MyAddon() {
        super("My Addon"); // Do not use parameters for the super function
    }
    
    @Override
    public void onLoad() {
        // The addon is initialized. Create additional content here.
    }
    
    @Override
    public void onDisable() {
        // Calls when the application exists or unfortunately crashes.
    }
}
```

### Build.info
The build.info is a file which contains information for the addon. It will be required to provide the compiled RenJava version your game uses. The version below is an example version please do not copy it.
```properties
dependencies="SomeAddon,OtherAddon"
ren.version="0.1.109"
```
This file is placed in the 'resources' directory. You will need to modify your pom file for the file to be included.
```xml
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <filtering>false</filtering>
            <includes>
                <include>**/*.*</include>
            </includes>
        </resource>
    </resources>
</build>
```