package blocks.category;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlockOreGlow extends Block {

    public BasicBlockOreGlow(String name, Material material, float hardness, float resistance, float glow) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setLightLevel(glow);
    }
}
