Torch-Burnout
=============
Torches burn out! And other stuff.

### Compiling
IMPORTANT: This is not guaranteed to work as it has not been tested extensively, and this mod is still in heavy development, and has not been released in a stable form yet.
***
#### Prerequisites
1. **WARNING:  Make sure you know EXACTLY what you're doing!  It's not any of our faults if your OS crashes, becomes corrupted, etc.**
2. Download and install the Java JDK [here] (http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).  Scroll down, accept the `Oracle Binary Code License Agreement for Java SE`, and download the one pertaining to your OS (necessary for MCP).
	* Go to `Control Panel\System and Security\System`, and click on `Advanced System Settings` on the left-hand side.
	* Click on `Environment Variables`.
  * Under `System Variables`, click `New`.
  * For `Variable Name`, input `JAVA_HOME`.
  * For `Variable Value`, input something similar to `;C:\Program Files (x86)\Java\jdk1.7.0_21` exactly as shown to the end (or wherever your Java JDK installation is), and click `Ok`.
  * Scroll down to a variable named `Path`, and double-click on it.
  * Append `;C:\Program Files (x86)\Java\jdk1.7.0_21\bin` (or your Java JDK installation directory\bin), and click `Ok`.
3. Download Apache Ant [here] (http://ant.apache.org).
	* Unzip the files anywhere you want, eg `C:\Program Files (x86)\Ant`.
  * Again, go to `Environment Variables` just like you did for the Java JDK.
  * Under `System Variables`, click `New`.
  * For `Variable Name`, input `ANT_HOME`.
  * For `Variable Value`, input `C:\Ant\apache-ant-1.9.0` (or your Ant directory\apache-ant-1.9.0).
  * Scroll down to `Path`, and double-click on it.
  * Append `;C:\Ant\apache-ant-1.9.0\bin` exactly as shown to the end (or your Ant directory\apache-ant-1.9.0\bin).
4. Download and install Github [here] (http://windows.github.com/) (Windows) or [here] (http://mac.github.com/) (Mac OS X 10.7+).  For Linux, you could download it as a .zip/tarball and unzip it.
	* Create an account.
  * Scroll to the top of this page, login at the top-right, and then click `Clone to Windows/Mac` near the top-left of the page.
  * You should see Github flash and `MC-Adventure/Torch-Burnout` appear.  (The local repository on Windows defaults to `C:\Users\(username)\Documents\GitHub\Torch-Burnout`, you can change it if you want but then you have to find it again on Github).
5. Create an empty directory for Torch Burnout development.  This directory is refernced as `mcdev` from now on.  It can be where you cloned this mod, but it'll be a little messy.


#### Setup MCP
1. Inside `mcdev`, create a directory named `forge`.
2. Download the latest forge **source** for Minecraft 1.6.2 and unzip it into `forge`.  Best way is to get it from [here] (http://files.minecraftforge.net/).
	* To verify, check if a application named `install.sh` exists. 
3. Execute `install.sh` (Linux and Mac) or `install.cmd` (Windows), both found in `mcdev\forge`. On Linux you might have to `chmod +x install.sh` before you can execute it. On some system configurations you need to execute `install.sh` from within the `forge` directory whereas on others it doesn't matter. Just check the output for error messages to find out what you need to do.

#### Setup Torch-Burnout
1. Inside `mcdev`, create a directory named `source`.
2. Move/clone `Torch-Burnout` into `source`.
3. Right now, you should have a directory that looks something like:

***

	mcdev
	\-forge
		\-complicated forge stuff (should have install.sh/cmd).
		\-mcp
			\-jars
	\-source
		\-Torch-Burnout
			\-Mod files (should have build.xml).
***

4. Inside `Torch-Burnout`, create a new file called `build.properties`.
	* Open it up with any text editor, and type into it the following (fully customizable except for `dir.development`):
 		* `dir.development=../../`
		* `dir.release=Releases`
		* `release.minecraft.version=1.6.2`
5. Open up your OS's command line (Command Prompt in Windows, Terminal in Linux and Mac).
6. Navigate to `mcdev\source\Torch-Burnout` by executing `cd mcdev's location\source\Torch-Burnout`.
7. Execute `ant release`. This will generally take around 5-15 minutes, depending on your computer.  If you've done everything right, `BUILD SUCCESSFUL` is displayed after it finishes.
	* If you see `BUILD FAILED`, check the error output (it should be right around `BUILD FAILED`), fix everything, and try again.
8. Go to `mcdev\source\Torch-Burnout\Releases\1.6.2\`.
	*  You should see a .jar named `torch-burnout-universal.jar`.
9. Copy the jar into your Minecraft mods folder, and play Minecraft!

#### Updating Your Repo (For Windows/Mac)
1. Check to see if we updated TB since you last compiled.  If he did, follow these instructions.
2. Open Github.
3. Double-click on MC-Adventure/Torch-Burnout.
4. At the top, there is a button named `Sync`/`Sync Branch` (or `Refreshing...` if it's still checking).
5. Click `Sync`, and wait for it to finish.
6. Re-compile (or move it to `mcdev\source` then re-compile, depending on what you did.)

###Contributing
***
#### Submitting a PR
So you found a bug in our code?  Think you can make it more efficient?  Want to help in general?  Great!

1. **IMPORTANT:  WE DO *NOT* WANT ANY** `build.xml` **CHANGES, UNLESS it fixes up something broken**
2. If you haven't already, create a Github account.
3. Click the little branch/plus icon at the top-right of this page (below your username).
4. Make the changes that you want to.
5. Click `Pull Request` at the top-middle of the page (left of your fork's name, to the right of `Watch` and `Fork`).
6. Enter your PR's title, and create a detailed description telling us what you changed.
7. Click `Send pull request`, and you're done!

#### Creating an Issue
Our mod causes crashes every time?  Have a suggestion?  Found a bug?  Create an issue now!

1. Please, please don't make any frivolous issues!  If it's a crash, try asking the people in IRC or MCF before creating an issue.  If it's a bug/suggestion, make sure it hasn't been reported/suggested already.  Thanks! :smile:
2. Go to [the issues page] (http://github.com/MC-Adventure/Torch-Burnout/issues).
3. Click `New Issue` right below `Graphs`.
4. Enter your Issue's title (something that summarizes your issue), and then create a detailed description ("Hey modders, could you add/change xxx?" or "Hey, found an exploit:  stuff").
5. Click `Submit new issue`, and you're done!

#### Credits
Thanks to the awesome people at Mojang, the Minecraft community, the people behind Minecraft Forge, [Pahimar] (http://github.org/pahimar) (for the excellent tutorials shown above and some very good modding tutorials), and everyone who has ever contributed something to minecraft.
