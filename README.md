# SimpleMOTD

A super simple [Paper](https://github.com/PaperMC/Paper) plugin that displays a Message of the Day to users in chat when they join your server.

## Install

Place the JAR file from the [latest release](https://github.com/TheBanterSquad/SimpleMOTD/releases/latest) into your `plugins/` directory and restart your server.

## Configuration

A configuration file will be created when the plugin initalises if one does not already exist. The file will be at  `plugins/SimpleMOTD/config.yml`.

### Keys

**motd** - This is the Message of the Day that will be displayed to users upon joining of your server. You can include [formatting codes](https://minecraft.gamepedia.com/Formatting_codes) by prefixing the code with the `&` symbol.

### Example configuration:
```yaml
motd: |-
  Welcome to the &2Banter Squad&f server!
  To play a different gamemode visit The Hub using &c/mv tp hub&f
```
Will render as
![Minecraft chat log showing the message rendered by the example configuration file](https://i.imgur.com/RevSWp2.png)

## Commands

### /smreload
Reloads the configuration file from disk.

**Permission** - simplemotd.reload
