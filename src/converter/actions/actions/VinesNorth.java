package converter.actions.actions;

import converter.actions.Action;
import converter.mapper.Mapper;
import minecraft.Block;
import minecraft.MaterialLegacy;
import minecraft.Position;
import vmfWriter.entity.solidEntity.FuncIllusionary;

/**
 *
 */
public class VinesNorth extends Action {

  public VinesNorth() {
    int[] temp = {MaterialLegacy.VINES};
    super.setMaterialUsedFor(temp);
  }

  @Override
  public void add(Mapper context, Position p, Block material) {
    Position end = context.getCuboidFinder()
      .getBestY(p, material);
    int parts = 8;
    Position offset = new Position(0, 0, 0);
    Position negativeOffset = new Position(0, 0, 7);
    context.addSolidEntity(
      new FuncIllusionary(context.createCuboid(p, end, parts, offset, negativeOffset, material)));
    context.markAsConverted(p, end);
  }
}
