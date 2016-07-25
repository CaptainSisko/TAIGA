package com.sosnitzka.taiga;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TAIGAGuiFactory implements IModGuiFactory {
    @Override
    public void initialize(Minecraft minecraftInstance) {
    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return TAIGAConfigGui.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }

    public static class TAIGAConfigGui extends GuiConfig {
        public TAIGAConfigGui(GuiScreen parentScreen) {
            super(parentScreen, getConfigElements(), TAIGA.MODID, false, false, I18n.format("gui.taiga_configuration.mainTitle"));
        }

        private static List<IConfigElement> getConfigElements() {
            List<IConfigElement> list = new ArrayList<IConfigElement>();
            list.add(new DummyConfigElement.DummyCategoryElement("mainCfg", "gui.taiga_configuration.ctgy.general", CategoryEntryGeneral.class));
            list.add(new DummyConfigElement.DummyCategoryElement("oreCfg", "gui.taiga_configuration.ctgy.ore", CategoryEntryOre.class));
            return list;
        }

        public static class CategoryEntryGeneral extends GuiConfigEntries.CategoryEntry {
            public CategoryEntryGeneral(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
                super(owningScreen, owningEntryList, prop);
            }

            @Override
            protected GuiScreen buildChildScreen() {
                Configuration configuration = TAIGAConfiguration.getConfig();
                ConfigElement cat_general = new ConfigElement(configuration.getCategory(TAIGAConfiguration.CATEGORY_NAME_GENERAL));
                List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
                String windowTitle = configuration.toString();

                return new GuiConfig(this.owningScreen, propertiesOnThisScreen, this.owningScreen.modID, TAIGAConfiguration.CATEGORY_NAME_GENERAL, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart, this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, windowTitle);
            }
        }

        public static class CategoryEntryOre extends GuiConfigEntries.CategoryEntry {
            public CategoryEntryOre(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
                super(owningScreen, owningEntryList, prop);
            }

            @Override
            protected GuiScreen buildChildScreen() {
                Configuration configuration = TAIGAConfiguration.getConfig();
                ConfigElement cat_general = new ConfigElement(configuration.getCategory(TAIGAConfiguration.CATEGORY_NAME_ORE));
                List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
                String windowTitle = configuration.toString();

                return new GuiConfig(this.owningScreen, propertiesOnThisScreen, this.owningScreen.modID, TAIGAConfiguration.CATEGORY_NAME_ORE, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart, this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, windowTitle);
            }
        }
    }
}